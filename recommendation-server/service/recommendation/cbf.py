import logging as log

from scipy.sparse import csr_matrix
from sklearn.metrics.pairwise import cosine_similarity

from dao.article_dao import get_article_indices
from dao.tf_idf_weights_dao import get_article_tf_idf

# init logging
log.basicConfig(level=log.DEBUG)


def get_tfidf_matrix(article_ids):
    """
    기사 식별키 리스트에 해당하는 TF-IDF 가중치 벡터 값 조회
    
    :param article_ids: 기사 식별키 리스트 
    :return: 기사 식별키 리스트에 해당하는 TF-IDF 가중치 벡터 리스트
    """

    tf_idf_matrix = get_article_tf_idf(article_ids)
    log.debug(len(tf_idf_matrix))

    rows = [data['article_id'] for data in tf_idf_matrix]
    cols = [data['keyword_vector'] for data in tf_idf_matrix]
    values = [data['weight'] for data in tf_idf_matrix]

    num_rows = max(rows) + 1  # 행의 개수는 가장 큰 article_tfidf_id + 1
    num_cols = max(cols) + 1  # 열의 개수는 가장 큰 keyword_vector + 1
    return csr_matrix((values, (rows, cols)), shape=(num_rows, num_cols), dtype=float)


def get_recommend_ids(article_id):
    """
    코사인 유사도를 사용한 기사 추천

    :param: article_id : 현재 읽고 있는 기사 식별키
    :return: 유사도가 높은 기사 제목 리스트
    """
    log.debug("cbf#getRecommendation called")

    # 1. 기사 PK 리스트 조회
    article_ids = [id[0] for id in get_article_indices()]

    # 2. 기사 PK 리스트에 해당하는 TF-IDF 가중치 값만 조회 후 csr_matrix로 변환
    tf_idf_matrix = get_tfidf_matrix(article_ids)

    # 3. TF-IDF 가중치를 사용해서 코사인 유사도 계산
    cosine_sim = cosine_similarity(tf_idf_matrix[1], tf_idf_matrix)

    # 4. 코사인 유사도 리스트 정렬 후 상위 N 개의 추천 결과 리스트 반환
    sim_scores = list(enumerate(cosine_sim[0]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:]
    articles_indices = [i[0] for i in sim_scores]

    return articles_indices[:10]
