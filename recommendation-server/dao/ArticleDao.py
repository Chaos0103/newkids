import pymysql as my


def getArticleIds():
    """
    기사 식별키 리스트 조회

    :return: 최근 3000개의 기사 식별키 리스트
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
            "SELECT `article_id` "
            "FROM `article` "
            "ORDER BY `created_date` DESC "
            "LIMIT 3000"
        )

        cursor.execute(sql)
        row = cursor.fetchall()

    except Exception as e:
        print(f"Exception={e}")
    finally:
        if connection:
            connection.close()
    return row
