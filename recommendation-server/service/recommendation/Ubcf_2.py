import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

# 사용자별 관심사 리스트
users_interests = [
    ["Hadoop", "Big Data", "HBase", "Java", "Spark", "Storm", "Cassandra"],
    ["NoSQL", "MongoDB", "Cassandra", "HBase", "Postgres"],
    ["Python", "scikit-learn", "scipy", "numpy", "statsmodels", "pandas"],
    ["R", "Python", "statistics", "regression", "probability"],
    ["machine learning", "regression", "decision trees", "libsvm"],
    ["Python", "R", "Java", "C++", "Haskell", "programming languages"],
    ["statistics", "probability", "mathematics", "theory"],
    ["machine learning", "scikit-learn", "Mahout", "neural networks"],
    ["neural networks", "deep learning", "Big Data", "artificial intelligence"],
    ["Hadoop", "Java", "MapReduce", "Big Data"],
    ["statistics", "R", "statsmodels"],
    ["C++", "deep learning", "artificial intelligence", "probability"],
    ["pandas", "R", "Python"],
    ["databases", "HBase", "Postgres", "MySQL", "MongoDB"],
    ["libsvm", "regression", "support vector machines"]
]

# 1. 사용자별 키워드 TF-IDF 행렬 조회
# 2. 현재 사용자의 TF-IDF 행렬 조회
# 3. 사용자 기반 협업 필터링 함수 수행

# 현재 결과
# libsvm (Similarity Score: 0.56)
# Spark (Similarity Score: 0.28)
# HBase (Similarity Score: 0.28)
# neural networks (Similarity Score: 0.28)
# Big Data (Similarity Score: 0.21)

# 사용자 수와 아이템 수를 추출
num_users = len(users_interests)
all_interests = list(set(interest for user_interests in users_interests for interest in user_interests))

# TF-IDF 벡터화
tfidf_vectorizer = TfidfVectorizer()
user_interests_str = [' '.join(user) for user in users_interests]
user_interest_tfidf = tfidf_vectorizer.fit_transform(user_interests_str)

# 코사인 유사도 계산
user_similarity_matrix = cosine_similarity(user_interest_tfidf)


# 사용자 기반 협업 필터링 함수
def user_based_collaborative_filtering(user_interest_tfidf, user_id, num_recommendations=5):
    # 사용자 관심사 간의 코사인 유사도 계산
    user_similarity_matrix = cosine_similarity(user_interest_tfidf)

    # 현재 사용자와 다른 사용자 간의 유사도를 확인
    user_similarities = user_similarity_matrix[user_id]

    # 유사도가 높은 사용자 순으로 정렬
    similar_users = np.argsort(user_similarities)[::-1]

    # 현재 사용자가 이미 관심을 가진 항목 제외
    current_user_interests = user_interest_tfidf[user_id]

    recommendations = []
    similarity_scores = []  # 유사도 점수를 저장할 리스트 추가

    for user in similar_users:
        if user == user_id:
            continue

        other_user_interests = user_interest_tfidf[user]

        # 현재 사용자가 관심을 가지지 않은 항목 중에서
        # 다른 사용자가 관심을 가진 항목을 추천 목록에 추가
        for i in range(len(all_interests)):
            if current_user_interests[0, i] == 0 and other_user_interests[0, i] > 0:
                recommendations.append(all_interests[i])
                similarity_scores.append(user_similarities[user])
                if len(recommendations) >= num_recommendations:
                    return recommendations, similarity_scores

    return recommendations, similarity_scores


# 예제 사용자에 대한 추천 실행
user_id = 0  # 예제 사용자 ID
recommended_interests, similarity_scores = user_based_collaborative_filtering(user_interest_tfidf, user_id)

print(f"User-Based Collaborative Filtering Recommendations for User {user_id}:")
for interest, similarity_score in zip(recommended_interests, similarity_scores):
    print(f"{interest} (Similarity Score: {similarity_score:.2f})")
