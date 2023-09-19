import logging as log

import pandas
from sklearn.metrics.pairwise import cosine_similarity

# init logging
log.basicConfig(level=log.DEBUG)


def getRecommendations(tfIdfMatrix):
    """
    코사인 유사도를 사용한 기사 추천

    :param tfIdfMatrix: TF-IDF 벡터행렬
    :return: 유사도가 높은 기사 제목 리스트
    """
    log.debug("CbfRecommendation#getRecommendation call")

    # DB에서 기사 데이터 로드 (DF 가 아니라 dict 로)
    data = pandas.DataFrame()
    # 코사인 유사도 계산
    cosine_sim = cosine_similarity(tfIdfMatrix[0], tfIdfMatrix)

    sim_scores = list(enumerate(cosine_sim[0]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:]
    articles_indices = [i[0] for i in sim_scores]

    # TODO 2023-09-11: 최영환 반환 값 수정해야함
    return data.iloc[articles_indices]
