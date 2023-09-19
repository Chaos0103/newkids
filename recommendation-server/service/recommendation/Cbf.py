import logging as log

import pandas
from scipy.sparse import csr_matrix
from sklearn.metrics.pairwise import cosine_similarity

from dao.ArticleDao import getArticleIds
from dao.TfIdfWeightsDao import getArticleTfIdf, getArticleTfIdfByArticleId

# init logging
log.basicConfig(level=log.DEBUG)


def get_recommend_ids(article_id):
    """
    코사인 유사도를 사용한 기사 추천

    :param tfIdfMatrix: TF-IDF 벡터행렬
    :return: 유사도가 높은 기사 제목 리스트
    """
    log.debug("CbfRecommendation#getRecommendation called")
    # 최종 로직 수행 과정
    # 1. 기사 PK 리스트 조회
    article_ids = getArticleIds()
    article_ids = [id[0] for id in article_ids]
    log.debug(f"Article Ids={article_ids}")

    # 2. 기사 PK 리스트에 해당하는 TF-IDF 가중치 값만 조회 후 csr_matrix로 변환
    tfIdfMatrix = getArticleTfIdf(article_ids)
    # log.debug(f"TF-IDF Matrix = {tfIdfMatrix}")
    rows = [data['article_id'] for data in tfIdfMatrix]
    cols = [data['keyword_vector'] for data in tfIdfMatrix]
    values = [data['weight'] for data in tfIdfMatrix]

    num_rows = max(rows) + 1  # 행의 개수는 가장 큰 article_tfidf_id + 1
    num_cols = max(cols) + 1  # 열의 개수는 가장 큰 keyword_vector + 1
    tfIdfMatrix = csr_matrix((values, (rows, cols)), shape=(num_rows, num_cols), dtype=float)

    # 3. TF-IDF 가중치를 사용해서 코사인 유사도 계산
    cosine_sim = cosine_similarity(tfIdfMatrix[1], tfIdfMatrix)
    # 4. 코사인 유사도 리스트 정렬 후 상위 N 개의 추천 결과 리스트 반환
    sim_scores = list(enumerate(cosine_sim[0]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:]
    articles_indices = [i[0] for i in sim_scores]

    return articles_indices[:10]
