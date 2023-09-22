import random
import time

from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

from dao.member_dao import get_member_id_by_member_key, get_members_all


def get_users_interests():
    # 사용자 수
    num_users = 100

    # 가능한 관심사 목록 (딕셔너리 형태로 구성)
    # possible_interests = [
    #     {"id": 1, "name": "Hadoop"},
    #     {"id": 2, "name": "Big Data"},
    #     {"id": 3, "name": "HBase"},
    #     {"id": 4, "name": "Java"},
    #     {"id": 5, "name": "Spark"},
    #     {"id": 6, "name": "Storm"},
    #     {"id": 7, "name": "Cassandra"},
    #     {"id": 8, "name": "NoSQL"},
    #     {"id": 9, "name": "MongoDB"},
    #     {"id": 10, "name": "Postgres"},
    #     {"id": 11, "name": "Python"},
    #     {"id": 12, "name": "scikit-learn"},
    #     {"id": 13, "name": "scipy"},
    #     {"id": 14, "name": "numpy"},
    #     {"id": 15, "name": "statsmodels"},
    #     {"id": 16, "name": "pandas"},
    #     {"id": 17, "name": "R"},
    #     {"id": 18, "name": "statistics"},
    #     {"id": 19, "name": "regression"},
    #     {"id": 20, "name": "probability"},
    #     {"id": 21, "name": "machine learning"},
    #     {"id": 22, "name": "decision trees"},
    #     {"id": 23, "name": "libsvm"},
    #     {"id": 24, "name": "C++"},
    #     {"id": 25, "name": "Haskell"},
    #     {"id": 26, "name": "programming languages"},
    #     {"id": 27, "name": "mathematics"},
    #     {"id": 28, "name": "theory"},
    #     {"id": 29, "name": "Mahout"},
    #     {"id": 30, "name": "neural networks"},
    #     {"id": 31, "name": "deep learning"},
    #     {"id": 32, "name": "artificial intelligence"},
    #     {"id": 33, "name": "MapReduce"},
    #     {"id": 34, "name": "databases"},
    #     {"id": 35, "name": "MySQL"},
    #     {"id": 36, "name": "Spring"},
    #     {"id": 37, "name": "JPA"},
    #     {"id": 38, "name": "QueryDSL"},
    #     {"id": 39, "name": "Nginx"},
    #     {"id": 40, "name": "HTTP"},
    # ]

    possible_interests = [
        {"id": 1, "name": "Algorithm"},
        {"id": 2, "name": "Data Structure"},
        {"id": 3, "name": "Computer Architecture"},
        {"id": 4, "name": "Operating System"},
        {"id": 5, "name": "Database Management"},
        {"id": 6, "name": "Software Development"},
        {"id": 7, "name": "Networking"},
        {"id": 8, "name": "Cybersecurity"},
        {"id": 9, "name": "Machine Learning"},
        {"id": 10, "name": "Artificial Intelligence"},
        {"id": 11, "name": "Web Development"},
        {"id": 12, "name": "Mobile App Development"},
        {"id": 13, "name": "Cloud Computing"},
        {"id": 14, "name": "IoT (Internet of Things)"},
        {"id": 15, "name": "Data Science"},
        {"id": 16, "name": "Robotics"},
        {"id": 17, "name": "Game Development"},
        {"id": 18, "name": "Computer Graphics"},
        {"id": 19, "name": "Human-Computer Interaction"},
        {"id": 20, "name": "Quantum Computing"},
        {"id": 21, "name": "Software Engineering"},
        {"id": 22, "name": "Programming Language"},
        {"id": 23, "name": "Database Design"},
        {"id": 24, "name": "Data Analysis"},
        {"id": 25, "name": "Parallel Computing"},
        {"id": 26, "name": "Network Security"},
        {"id": 27, "name": "Cloud Security"},
        {"id": 28, "name": "Data Mining"},
        {"id": 29, "name": "Computer Vision"},
        {"id": 30, "name": "Natural Language Processing"},
        {"id": 31, "name": "Deep Learning"},
        {"id": 32, "name": "Computer Ethics"},
        {"id": 33, "name": "Information Retrieval"},
        {"id": 34, "name": "Computer Hardware"},
        {"id": 35, "name": "Embedded Systems"},
        {"id": 36, "name": "Software Testing"},
        {"id": 37, "name": "Distributed Systems"},
        {"id": 38, "name": "Computer Science Education"},
        {"id": 39, "name": "Mobile Computing"},
        {"id": 40, "name": "Computer Networks"},
        {"id": 41, "name": "Operating System Design"},
        {"id": 42, "name": "Computer Security"},
        {"id": 43, "name": "Computer Forensics"},
        {"id": 44, "name": "Cloud Computing Security"},
        {"id": 45, "name": "Quantum Cryptography"},
        {"id": 46, "name": "Software Development Methodologies"},
        {"id": 47, "name": "Cryptography"},
        {"id": 48, "name": "Wireless Networks"},
        {"id": 49, "name": "Computer Simulation"},
        {"id": 50, "name": "Computer Animation"},
        {"id": 51, "name": "Computational Biology"},
        {"id": 52, "name": "Bioinformatics"},
        {"id": 53, "name": "Computer Music"},
        {"id": 54, "name": "Humanoid Robotics"},
        {"id": 55, "name": "Computer Ethics"},
        {"id": 56, "name": "Computer-Assisted Design (CAD)"},
        {"id": 57, "name": "Virtual Reality"},
        {"id": 58, "name": "Augmented Reality"},
        {"id": 59, "name": "Quantum Programming"},
        {"id": 60, "name": "Computer Forensics"},
        {"id": 61, "name": "Blockchain Technology"},
        {"id": 62, "name": "Data Warehousing"},
        {"id": 63, "name": "3D Printing"},
        {"id": 64, "name": "Computer Vision"},
        {"id": 65, "name": "Computational Linguistics"},
        {"id": 66, "name": "Natural Language Generation"},
        {"id": 67, "name": "Humanoid Robotics"},
        {"id": 68, "name": "Autonomous Vehicles"},
        {"id": 69, "name": "Quantum Algorithms"},
        {"id": 70, "name": "Data Engineering"},
        {"id": 71, "name": "Machine Vision"},
        {"id": 72, "name": "Quantum Machine Learning"},
        {"id": 73, "name": "Data Analytics"},
        {"id": 74, "name": "Computerized Modeling"},
        {"id": 75, "name": "Information Security"},
        {"id": 76, "name": "Human-Computer Interaction Design"},
        {"id": 77, "name": "Embedded Software"},
        {"id": 78, "name": "Parallel Processing"},
        {"id": 79, "name": "Computer Algebra Systems"},
        {"id": 80, "name": "Computational Physics"},
        {"id": 81, "name": "Quantum Information Theory"},
        {"id": 82, "name": "Algorithmic Trading"},
        {"id": 83, "name": "Computer Vision Algorithms"},
        {"id": 84, "name": "Quantum Computing Hardware"},
        {"id": 85, "name": "3D Graphics Programming"},
        {"id": 86, "name": "Quantum Cryptography"},
        {"id": 87, "name": "Bioinformatics"},
        {"id": 88, "name": "Computational Neuroscience"},
        {"id": 89, "name": "Digital Signal Processing"},
        {"id": 90, "name": "Quantum Software Development"},
        {"id": 91, "name": "Humanoid Robot Control"},
        {"id": 92, "name": "Quantum Networking"},
        {"id": 93, "name": "Cognitive Computing"},
        {"id": 94, "name": "Cyber-Physical Systems"},
        {"id": 95, "name": "Computer Music Composition"},
        {"id": 96, "name": "Quantum Robotics"},
        {"id": 97, "name": "Computational Chemistry"},
        {"id": 98, "name": "Cybersecurity Governance"},
        {"id": 99, "name": "Computer Ethics and Society"},
        {"id": 100, "name": "Quantum Communication"},
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
    """
    사용자 기반 협업 필터링 추천 - 사용자별 관심 키워드를 통한 추천

    :param member_key: 회원 고유값
    :return: 추천 키워드 리스트
    """
    # 회원 데이터 조회
    start = time.time()
    members_all = get_members_all()
    end = time.time()
    print(f"running time: {end - start: .5f}")

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


def get_most_similar_user(member_key):
    """
    현재 사용자와 가장 유사한 사용자가 최근 읽은 기사 추천
    
    :param member_key: 
    :return: 
    """
    # 회원 데이터 조회
    start = time.time()
    members_all = get_members_all()
    end = time.time()
    print(f"running time: {end - start: .5f}")

    users_interests = get_users_interests()
    users_tfidf_matrix = get_users_tfidf_matrix(users_interests)

    # 코사인 유사도 계산 (사용자 간의 유사도)
    user_similarity = cosine_similarity(users_tfidf_matrix, users_tfidf_matrix)

    # 현재 사용자 인덱스
    target_user_index = get_member_id_by_member_key(member_key)[0]

    # 가장 유사한 사용자 1명 선택 (코사인 유사도가 가장 높은 사용자)
    most_similar_user_idx = user_similarity[target_user_index].argsort()[::-1][1]
    most_similar_user_key = users_interests[most_similar_user_idx]['member_key']

    # 가장 유사한 사용자의 회원 고유값을 사용해 최근 읽은 기사 조회 후 반환
    
    return most_similar_user_key


# get_most_similar_user('memberKey1')

# # 회원 데이터 조회
# start = time.time()
# members_all = get_members_all()
# end = time.time()
# print(f"running time: {end - start: .5f}")
#
# # 호출
# start = time.time()
# recommendations = get_ubcf_recommendations('memberKey1')
# end = time.time()
# print(f"running time: {end - start: .5f}")
#
# # 결과 출력: 추천 관심사 목록 출력
# print("Recommended Interests:")
# for interest in recommendations:
#     print(f"- {interest['name']}")

# target_user_index = 0
# # 결과 출력: 선택한 사용자의 관심사 출력
# print(f"\nUser {users_interests[target_user_index]['member_key']}'s Interests:")
# for interest in users_interests[target_user_index]['interests']:
#     print(f"- {interest['name']}")
