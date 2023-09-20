# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import pymysql


# DB저장 클래스
class NewsPipeline:
    def __init__(self):
        # DB정보
        self.connect = pymysql.connect(
            host = 'localhost',
            db = 'test',
            user = 'root',
            password = 'ssafyc204',
        )
        self.cursor = self.connect.cursor()

    def process_item(self, item, spider):
        try:
            self.cursor.execute("SELECT * FROM article WHERE title = %s", (item['title'],))
            existing_data = self.cursor.fetchone()

            if not existing_data:
                self.cursor.execute(
                    # "INSERT INTO article (title, sub_title, writer, published_date, content, thumbnail_img, create_date, last_modified_date, all_keywords, html_content, url) value(%s, %s, %s, %s, %s, %s, now(), now(), '1', %s, %s)",
                    "INSERT INTO article "
                    "(title, sub_title, writer, published_date, content, thumbnail_img, "
                    "all_keywords, html_content) "
                    "VALUES "
                    "(%s, %s, %s, %s, %s, %s, '1', %s)",
                    (
                        item['title'],
                        item['sub_title'],
                        item['writer'],
                        item['published_date'],
                        item['content'],
                        item['thumbnail_img'],
                        item['html_content'],
                    ))
                self.connect.commit()
                
                # 전체 이미지 url 저장 SQL Query인데
                # 현재는 저장하게 되면 오류
                # id값을 알 수 없기 때문에
                # self.cursor.execute(
                #     "INSERT INTO article_image "
                #     "(url) "
                #     "VALUES "
                #     "(%s)",
                #     (
                #         item['imgs'],
                #     ))
            
                # self.connect.commit()
            else:
                print(f"제목 '{item['title']}'이 이미 존재합니다.")
        except Exception as e:
            print(e)

        return item
    
    def close_spider(self, spider):
        self.connect.close()