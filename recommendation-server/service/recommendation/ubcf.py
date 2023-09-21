import random

from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

from dao.member_dao import get_member_id_by_member_key


def get_users_interests():
    # 사용자 수
    num_users = 100

    # 가능한 관심사 목록 (딕셔너리 형태로 구성)
    possible_interests = [
        {"id": 1, "name": "Hadoop"},
        {"id": 2, "name": "Big Data"},
        {"id": 3, "name": "HBase"},
        {"id": 4, "name": "Java"},
        {"id": 5, "name": "Spark"},
        {"id": 6, "name": "Storm"},
        {"id": 7, "name": "Cassandra"},
        {"id": 8, "name": "NoSQL"},
        {"id": 9, "name": "MongoDB"},
        {"id": 10, "name": "Postgres"},
        {"id": 11, "name": "Python"},
        {"id": 12, "name": "scikit-learn"},
        {"id": 13, "name": "scipy"},
        {"id": 14, "name": "numpy"},
        {"id": 15, "name": "statsmodels"},
        {"id": 16, "name": "pandas"},
        {"id": 17, "name": "R"},
        {"id": 18, "name": "statistics"},
        {"id": 19, "name": "regression"},
        {"id": 20, "name": "probability"},
        {"id": 21, "name": "machine learning"},
        {"id": 22, "name": "decision trees"},
        {"id": 23, "name": "libsvm"},
        {"id": 24, "name": "C++"},
        {"id": 25, "name": "Haskell"},
        {"id": 26, "name": "programming languages"},
        {"id": 27, "name": "mathematics"},
        {"id": 28, "name": "theory"},
        {"id": 29, "name": "Mahout"},
        {"id": 30, "name": "neural networks"},
        {"id": 31, "name": "deep learning"},
        {"id": 32, "name": "artificial intelligence"},
        {"id": 33, "name": "MapReduce"},
        {"id": 34, "name": "databases"},
        {"id": 35, "name": "MySQL"}
    ]

    # 데이터 생성
    users_interests = []
    for member_key in range(1, num_users + 1):
        num_interests = random.randint(1, 10)  # 최대 10개의 관심사
        user_interests = random.sample(possible_interests, num_interests)

        users_interests.append({"member_key": f'memberKey{member_key}', "interests": user_interests})

    # # 결과 출력
    # for user in users_interests[:10]:
    #     print(user)
    return users_interests


def get_users_tfidf_matrix(users_interests):
    # TF-IDF 벡터화를 위해 관심 키워드를 텍스트로 변환
    user_interest_texts = [" ".join([interest['name'] for interest in user['interests']]) for user in users_interests]

    # TF-IDF 벡터화
    tfidf_vectorizer = TfidfVectorizer()

    return tfidf_vectorizer.fit_transform(user_interest_texts)


def get_ubcf_recommendations(member_key):
    users_interests = get_users_interests()
    users_tfidf_matrix = get_users_tfidf_matrix(users_interests)

    # 코사인 유사도 계산 (사용자 간의 유사도)
    user_similarity = cosine_similarity(users_tfidf_matrix, users_tfidf_matrix)

    # 특정 사용자 선택 (예시로 1번 사용자 선택)
    target_user_index = get_member_id_by_member_key(member_key)[0]

    # 유사한 사용자 선택 (코사인 유사도가 가장 높은 상위 N명)
    num_neighbors = 5
    similar_users_indices = user_similarity[target_user_index].argsort()[:-num_neighbors - 1:-1]

    # 사용자 간의 관심사 유사도 계산 및 관심사 추천
    recommendations = []
    similarity_scores = []

    for user_index in similar_users_indices:
        if user_index == target_user_index:
            continue  # 자기 자신과의 유사도는 계산하지 않음

        similar_user_interests = users_interests[user_index]["interests"]

        # 현재 사용자의 관심사로 등록된 항목을 추천 목록에서 제외
        similar_user_interests = [interest for interest in similar_user_interests if
                                  interest not in users_interests[target_user_index]["interests"]]
        similarity_scores.append(user_similarity[target_user_index][user_index])
        recommendations.extend(similar_user_interests)

    # 중복 제거
    return list({interest['name']: interest for interest in recommendations}.values())


# 호출
# recommendations = get_ubcf_recommendations('memberKey1')

# # 결과 출력: 추천 관심사 목록 출력
# print("Recommended Interests:")
# for interest in recommendations:
#     print(f"- {interest['name']}")

# target_user_index = 0
# # 결과 출력: 선택한 사용자의 관심사 출력
# print(f"\nUser {users_interests[target_user_index]['member_key']}'s Interests:")
# for interest in users_interests[target_user_index]['interests']:
#     print(f"- {interest['name']}")
