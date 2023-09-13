import logging as log

from flask import Flask, request, jsonify

app = Flask(__name__)

# init logging
log.basicConfig(level=log.DEBUG)


@app.route('/contents-based-filtering')
def getRecommendationsByContentBasedFilter():
    """
    컨텐츠 기반 필터링 추천 API

    :return: 컨텐츠 기반 필터링 추천 결과 목록
    """

    parameters = request.args.to_dict()
    if len(parameters) == 0:
        return "BAD_REQUEST"

    articleId = parameters.get("articleId")
    log.debug(f"articleId={articleId}")
    # 현재 보고 있는 기사의 TF-IDF 가중치 가져옴
    # TF-IDF 행렬의 첫번째 데이터로 만듬

    # TODO 2023-09-11: 최영환 컨텐츠 기반 필터링 수행
    # TF-IDF 가중치 벡터 조회 호출
    # 보고있는 기사를 제외하고 조회된 TF-IDF 가중치 벡터를 보내서 코사인 유사도 얻음 (서비스 내부 로직)

    # 기사 데이터 로드 (서비스 내부 로직)
    # 얻은 코사인 유사도와 DB에서 로드한 기사 데이터를 사용해 추천 응답 생성 (서비스 내부 로직)

    return f"articleId: {articleId}"


@app.route('/item-based-collaborative-filetering')
def getRecommendationsByIBCF():
    """
    아이템 기반 협업 필터링 추천 API
    
    :return: 아이템 기반 협업 필터링 추천 결과 목록
    """
    parameters = request.args.to_dict()
    if len(parameters) == 0:
        return "BAD_REQUEST"

    memberId = parameters.get("memberId")
    log.debug(f"memberId: {memberId}")

    # 입력 받은 회원의 관심사 목록

    # 입력 받은 사용자를 제외한 다른 회원들의 관심사 목록

    # TF-IDF 벡터 행렬 구하기
    
    # 코사인 유사도 구하기

    return f"memberId: {memberId}"


@app.route('/user-based-collaborative-filetering')
def getRecommendationsByUBCF():
    """
    사용자 기반 협업 필터링 추천 API

    :return: 사용자 기반 협업 필터링 추천 결과 목록
    """
    parameters = request.args.to_dict()
    if len(parameters) == 0:
        return "BAD_REQUEST"

    memberId = parameters.get("memberId")
    log.debug(f"memberId: {memberId}")

    return f"memberId: {memberId}"


if __name__ == '__main__':
    app.run()
