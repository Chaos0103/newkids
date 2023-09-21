import random

from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

# 사용자 수
num_users = 100

# 가능한 관심사 목록
possible_interests = [
    "Hadoop", "Big Data", "HBase", "Java", "Spark",
    "Storm", "Cassandra", "NoSQL", "MongoDB", "Postgres",
    "Python", "scikit-learn", "scipy", "numpy", "statsmodels",
    "pandas", "R", "statistics", "regression", "probability",
    "machine learning", "decision trees", "libsvm",
    "C++", "Haskell", "programming languages",
    "mathematics", "theory", "Mahout", "neural networks",
    "deep learning", "artificial intelligence", "MapReduce",
    "databases", "MySQL"
]

print(len(possible_interests))

# 데이터 생성
users_interests = []
for user_id in range(1, num_users + 1):
    num_interests = random.randint(1, 5)  # 최대 5개의 관심사
    user_interests = random.sample(possible_interests, num_interests)
    users_interests.append({"user_id": user_id, "interests": user_interests})

# 결과 출력
for user in users_interests[:10]:
    print(user)

# 1. 사용자별 키워드 TF-IDF 행렬 조회

# TF-IDF 벡터화를 위해 관심 키워드를 텍스트로 변환
user_interest_texts = [" ".join(user["interests"]) for user in users_interests]

# TF-IDF 벡터화
tfidf_vectorizer = TfidfVectorizer()
user_tfidf_matrix = tfidf_vectorizer.fit_transform(user_interest_texts)

# 코사인 유사도 계산 (사용자 간의 유사도)
user_similarity = cosine_similarity(user_tfidf_matrix, user_tfidf_matrix)

# 특정 사용자 선택
target_user_index = 0

# 유사한 사용자 선택 (코사인 유사도가 가장 높은 상위 N명)
num_neighbors = 3
similar_users_indices = user_similarity[target_user_index].argsort()[:-num_neighbors - 1:-1]

# 추천 생성 (유사한 사용자의 관심 키워드 중에서 현재 사용자가 관심 없는 것을 추천)
# 모든 사용자에 대한 추천 생성
for target_user_index in range(len(users_interests)):
    target_user_interests = set(users_interests[target_user_index]["interests"])
    recommendations = []

    for user_index in similar_users_indices:
        similar_user_interests = set(users_interests[user_index]["interests"])
        recommendations.extend(similar_user_interests - target_user_interests)

    print(f"Recommendations for User {target_user_index + 1}: {recommendations}")

# 각 사용자의 유사도 점수 출력
for i, user_info in enumerate(users_interests):
    user_id = user_info["user_id"]
    similarity_scores = user_similarity[i]
    similar_users = [(users_interests[j]["user_id"], similarity) for j, similarity in enumerate(similarity_scores) if
                     i != j]
    similar_users.sort(key=lambda x: x[1], reverse=True)

    print(f"Similarity scores for User {user_id}:")
    for similar_user_id, similarity in similar_users:
        if similarity > 0:
            print(f"User {similar_user_id}: {similarity:.2f}")
    print()
