import logging as log

from flask import Flask, request, jsonify
from flask_restx import Api, Resource, fields

from service.recommendation.Cbf import get_recommend_ids
from service.article.article import get_recommend_articles

app = Flask(__name__)
api = Api(app, version="1.0", title="기사 추천 API 문서", doc="/api-docs")

Api = api.namespace("recommend", "추천 기사 목록 조회")

# init logging
log.basicConfig(level=log.DEBUG)

articles = [
    {
        "articleId": 1,
        "title": "[생활뉴스] 토끼와 함께라면 행복져요!",
        "thumbnail": "기사 썸네일"
    },
    {
        "articleId": 2,
        "title": "코골이 치료, 수면무호흡증 여부 먼저 확인하세요.",
        "thumbnail": "기사 썸네일"
    }
]

article_fields = Api.model(
    'article', {
        'articleId': fields.Integer(default=1),
        'title': fields.String(default='[생활뉴스] 토끼와 함께라면 행복져요!'),
        'thumbnail': fields.String(default='썸네일 URL')
    }
)

recommend_articles = Api.model(
    'articleList', {
        'articles': fields.List(fields.Nested(article_fields))
    }
)


@Api.route('/content-base-filter')
@Api.doc(params={
    'articleId': {'in': 'query', 'description': '기사 식별키', 'default': '1'}
})
class CbfResult(Resource):
    @Api.response(200, "Success", recommend_articles)
    def get(self):
        """
        컨텐츠 기반 필터링 추천 API

        컨텐츠 기반 필터링 추천 결과 목록
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
        # 코사인 유사도를 사용해 추천 기사 리스트를 얻음

        recommend_ids = get_recommend_ids(articleId)
        articles = get_recommend_articles(recommend_ids)

        return jsonify(articles)


@Api.route('/collaborative-filter')
@Api.doc(params={
    'loginId': {'in': 'query', 'description': '회원 로그인 아이디', 'default': '1'},
    'age': {'in': 'query', 'description': '회원 연령', 'default': '10'}
})
class CfResult(Resource):
    @Api.response(200, "Success", recommend_articles)
    def get(self):
        """
        협업 필터링 추천 API

        협업 필터링 추천 결과 목록
        """
        parameters = request.args.to_dict()
        if len(parameters) == 0:
            return "BAD_REQUEST"

        memberId = parameters.get("memberId")
        log.debug(f"memberId: {memberId}")

        age = parameters.get("age")
        log.debug(f"age: {age}")

        # 입력 받은 회원의 관심사 목록

        # 입력 받은 사용자를 제외한 다른 회원들의 관심사 목록

        # TF-IDF 벡터 행렬 구하기

        # 코사인 유사도를 구해서 추천 알고리즘 수행 -> 키워드 리스트 추출

        # 해당 키워드 리스트 랜덤조회

        return jsonify(articles)


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
