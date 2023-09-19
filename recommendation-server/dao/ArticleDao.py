import logging as log

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
            host="127.0.0.1",
            port=3306,
            user='ssafy',
            password='ssafy',
            db='newkids',
            charset='utf8',
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
        cursor.close()

    except Exception as e:
        print(f"Exception={e}")
    finally:
        if connection:
            connection.close()
    return row


def getArticles(articleIds: list):
    """
    기사 식별키 리스트에 해당하는 기사 조회

    :param articleIds: 기사 식별키 리스트
    :return: 기사 식별키 리스트에 해당하는 기사 리스트
    """
    row = None
    connection = None

    try:
        connection = my.connect(
            host="127.0.0.1",
            port=3306,
            user='ssafy',
            password='ssafy',
            db='newkids',
            charset='utf8',
            cursorclass=my.cursors.DictCursor
        )

        cursor = connection.cursor()
        placeholders = ', '.join(['%s'] * len(articleIds))
        log.debug(articleIds)

        sql = (
            "SELECT `article_id`, `title` "
            "FROM `article` "
            f"WHERE `article_id` IN ({placeholders}) "
        )
        log.debug(sql)

        cursor.execute(sql, articleIds)
        row = cursor.fetchall()
        cursor.close()

    except Exception as e:
        print(f"Exception={e}")
    finally:
        if connection:
            connection.close()
    return row
