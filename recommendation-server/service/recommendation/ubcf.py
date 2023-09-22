import random
import time
from collections import defaultdict

from sklearn.feature_extraction.text import TfidfVectorizer, CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

from dao.article_dao import get_article_indices_by_member_key
from dao.member_dao import get_member_id_by_member_key, get_members_all


def get_members_interests():
    """
    회원별 관심 키워드 조회 (현재는 더미데이터 생성 함수)
    추후 쿼리 호출 함수로 변경해야함
    
    :return: 회원별 관심 키워드 리스트
    """

    # 사용자 수 (더미데이터)
    num_members = 10000
    # 가능한 관심사 (더미데이터)
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
    members_interests = []
    for member_key in range(1, num_members + 1):
        num_interests = random.randint(10, 50)  # 최대 10개의 관심사
        member_interests = random.sample(possible_interests, num_interests)

        members_interests.append({"member_key": f'memberKey{member_key}', "interests": member_interests})

    return members_interests


def get_members_tfidf_matrix(members_interests):
    """
    회원별 관심 키워드 TF-IDF 가중치 벡터화

    :param members_interests: 회원별 관심 키워드 리스트
    :return: 회원별 관심 키워드 TF-IDF 벡터
    """
    # TF-IDF 벡터화를 위해 관심 키워드를 텍스트로 변환
    member_interest_texts = [" ".join([interest['name'] for interest in member['interests']]) for member in
                             members_interests]

    # TF-IDF 벡터화
    tfidf_vectorizer = CountVectorizer()

    return tfidf_vectorizer.fit_transform(member_interest_texts)


def get_ubcf_recommendations(member_key):
    """
    사용자 기반 협업 필터링 추천 - 사용자별 관심 키워드를 통한 추천

    :param member_key: 회원 고유값
    :return: 추천 키워드 리스트
    """
    # 회원 데이터 조회
    start = time.time()
    members_interests = get_members_interests()
    end = time.time()
    print(f"init running time: {end - start: .5f}")

    members_tfidf_matrix = get_members_tfidf_matrix(members_interests)

    # 코사인 유사도 계산 (사용자 간의 유사도)
    member_similarity = cosine_similarity(members_tfidf_matrix, members_tfidf_matrix)

    # 특정 사용자 선택 (예시로 1번 사용자 선택)
    target_member_idx = get_member_id_by_member_key(member_key)[0] - 1

    # 유사한 사용자 선택 (코사인 유사도가 가장 높은 상위 N명)
    num_neighbors = 5
    similar_members_indices = member_similarity[target_member_idx].argsort()[:-num_neighbors - 1:-1]

    # 사용자 간의 관심사 유사도 계산 및 관심사 추천
    recommendations = []
    similarity_scores = []

    for member_idx in similar_members_indices:
        if member_idx == target_member_idx:
            continue  # 자기 자신과의 유사도는 계산하지 않음

        similar_member_interests = members_interests[member_idx]["interests"]

        # 현재 사용자의 관심사로 등록된 항목을 추천 목록에서 제외
        similar_member_interests = [interest for interest in similar_member_interests if
                                    interest not in members_interests[target_member_idx]["interests"]]
        similarity_scores.append(member_similarity[target_member_idx][member_idx])
        recommendations.extend(similar_member_interests)

    # 중복 제거
    return list({interest['name']: interest for interest in recommendations}.values())


def get_most_similar_member(member_key):
    """
    현재 사용자와 가장 유사한 사용자가 최근 읽은 기사 추천
    
    :param member_key: 회원 고유값 
    :return: 가장 유사한 사용자가 최근 읽은 기사 중 현재 사용자가 읽지 않은 기사
    """
    # 회원 데이터 조회
    members_interests = get_members_interests()
    members_tfidf_matrix = get_members_tfidf_matrix(members_interests)

    # 코사인 유사도 계산 (사용자 간의 유사도)
    member_similarity = cosine_similarity(members_tfidf_matrix, members_tfidf_matrix)

    # 현재 사용자 인덱스
    target_member_index = get_member_id_by_member_key(member_key)[0] - 1

    # 가장 유사한 사용자 1명 선택 (코사인 유사도가 가장 높은 사용자)
    similar_members_indices = member_similarity[target_member_index].argsort()[::-1]
    most_similar_member_idx = -1
    for member_idx in similar_members_indices:
        if member_idx == target_member_index:
            continue
        most_similar_member_idx = member_idx

    most_similar_member_key = members_interests[most_similar_member_idx]['member_key']
    print(most_similar_member_key)

    # 가장 유사한 사용자의 회원 고유값을 사용해 최근 읽은 기사 조회 후 반환
    read_indices = get_article_indices_by_member_key(member_key)
    print(read_indices)
    article_indices = get_article_indices_by_member_key(most_similar_member_key)
    print(article_indices)

    read_indices = [id[0] for id in read_indices]
    article_indices = [id[0] for id in article_indices]

    unread_indices = [article_id for article_id in article_indices if article_id not in read_indices]

    return unread_indices


# get_most_similar_user('memberKey1')

# # 회원 데이터 조회
# start = time.time()
# members_all = get_members_all()
# end = time.time()
# print(f"running time: {end - start: .5f}")
#
# 호출
start = time.time()
recommendations = get_ubcf_recommendations('memberKey1')
end = time.time()
print(f"running time: {end - start: .5f}")

# 결과 출력: 추천 관심사 목록 출력
print("Recommended Interests:")
for interest in recommendations:
    print(f"- {interest['name']}")

target_user_index = get_member_id_by_member_key('memberKey1')[0]
members_interests = get_members_interests()
# 결과 출력: 선택한 사용자의 관심사 출력
print(f"\nUser {members_interests[target_user_index]['member_key']}'s Interests:")
for interest in members_interests[target_user_index]['interests']:
    print(f"- {interest['name']}")


def jaccard_similarity(set1, set2):
    intersection = len(set1.intersection(set2))
    union = len(set1.union(set2))
    return intersection / union if union != 0 else 0.0

# 더미 데이터 가져오기
members_interests = get_members_interests()

# 자카드 유사도 계산 대상 회원 선택 (예: 첫 번째 회원)
target_member = members_interests[0]
target_interests = set(item['name'] for item in target_member['interests'])

# 자카드 유사도 계산 및 결과 저장
similarities = defaultdict(float)
for member in members_interests:
    if member == target_member:
        continue
    member_interests = set(item['name'] for item in member['interests'])
    similarity = jaccard_similarity(target_interests, member_interests)
    similarities[member['member_key']] = similarity

# 자카드 유사도가 가장 높은 상위 N명 추천 (예: 상위 5명)
top_n = 5
sorted_recommendations = sorted(similarities.items(), key=lambda x: x[1], reverse=True)[:top_n]

# 추천 결과 출력
print(f"{target_member['member_key']}의 관심사 : {target_member['interests']}")
print(f"{target_member['member_key']}의 관심사와 유사한 회원 추천:")
for member_key, similarity in sorted_recommendations:
    print(f"회원: {member_key}, 유사도: {similarity}")
    member_idx = get_member_id_by_member_key(member_key)[0] - 1
    print(members_interests[member_idx])
