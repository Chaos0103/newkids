import pymysql as my


def getArticleTfIdf(articleIds: list):
    """
    기사 식별키 리스트에 해당하는 TF-IDF 가중치 벡터 행렬 조회

    :param articleIds: 기사 식별키 리스트
    :return: 기사 식별키 리스트에 해당하는 TF-IDF 가중치 벡터 행렬
    """
    row = None
    connection = None

    try:
        connection = my.connect(
            host="",
            password="",
            database="",
            charset="utf8mb5",
            cursorclass=my.cursors.DictCursor
        )

        cursor = connection.cursor()

        sql = (
            "SELECT `article_tfidf_id`, `article_id`, `keyword_vector`, `weight` "
            "FROM `article_tfidf` "
            f"WHERE `article_id` IN {articleIds} "
        )

        cursor.execute(sql, articleIds)
        row = cursor.fetchall()

    except Exception as e:
        print(f"Exception={e}")
    finally:
        if connection:
            connection.close()
    return row


def getArticleTfIdfByArticleId(articleId):
    """
    기사 식별키에 해당하는 TF-IDF 가중치 벡터 행렬 조회

    :param articleId: 기사 식별키
    :return: 기사 식별키에 해당하는 TF-IDF 가중치 벡터 행렬
    """
    row = None
    connection = None

    try:
        connection = my.connect(
            host="",
            password="",
            database="",
            charset="utf8mb5",
            cursorclass=my.cursors.DictCursor
        )

        cursor = connection.cursor()

        sql = (
            "SELECT `article_tfidf_id`, `article_id`, `keyword_vector`, `weight` "
            "FROM `article_tfidf` "
            f"WHERE `article_id` = {articleId} "
        )

        cursor.execute(sql, articleId)
        row = cursor.fetchall()

    except Exception as e:
        print(f"Exception={e}")
    finally:
        if connection:
            connection.close()
    return row
