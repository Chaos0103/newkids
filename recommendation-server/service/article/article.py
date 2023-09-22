from dao.article_dao import getArticles


def get_recommend_articles(article_ids):
    return getArticles(article_ids)
