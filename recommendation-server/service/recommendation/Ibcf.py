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

# 사용자 수와 아이템 수를 추출
num_users = len(users_interests)
all_interests = list(set(interest for user_interests in users_interests for interest in user_interests))

# TF-IDF 벡터화
tfidf_vectorizer = TfidfVectorizer()
user_interests_str = [' '.join(user) for user in users_interests]
user_interest_tfidf = tfidf_vectorizer.fit_transform(user_interests_str)


# 아이템 기반 협업 필터링 함수
def item_based_collaborative_filtering(user_interest_tfidf, user_id, num_recommendations=5):
    # 사용자 관심사와 아이템 관심사 간의 코사인 유사도 계산
    item_similarity = cosine_similarity(user_interest_tfidf[user_id], user_interest_tfidf)

    # 아이템 유사도가 높은 순으로 정렬
    similar_items = np.argsort(item_similarity)[0][::-1]

    # 사용자가 이미 관심을 가진 항목 제외
    current_user_interests = user_interest_tfidf[user_id].toarray()

    recommendations = []
    similarity_scores = []
    for item in similar_items:
        if current_user_interests[0, item] == 0:
            recommendations.append(all_interests[item])
            similarity_scores.append(item_similarity[0, item])
            if len(recommendations) >= num_recommendations:
                return recommendations, similarity_scores

    return recommendations, similarity_scores


# 예제 사용자에 대한 추천 실행
user_id = 0  # 예제 사용자 ID
recommended_interests, similarity_scores = item_based_collaborative_filtering(user_interest_tfidf, user_id)

print(f"Item-Based Collaborative Filtering Recommendations for User {user_id}:")
for interest, similarity_score in zip(recommended_interests, similarity_scores):
    print(f"{interest} (Similarity Score: {similarity_score:.2f})")
