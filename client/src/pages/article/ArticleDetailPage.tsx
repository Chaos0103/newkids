import ArticleContent from 'components/organisms/article/ArticleContent';
import ArticleHeader from 'components/organisms/article/ArticleHeader';
import ArticleKeywordList from 'components/organisms/article/ArticleKeywordList';
import DetailRecommendedArticleList from 'components/organisms/article/DetailRecommendedArticleList';
import Footer from 'components/organisms/common/Footer';
import { DUMMY_KEYWORDS } from 'constants/dummy';
import PageLayout from 'layouts/common/PageLayout';
import ArticleDetailPageLayout from 'layouts/page/ArticleDetailPageLayout';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { IArticleDetail } from 'types/article';
import { getArticleApi } from 'utils/apis/article';

function ArticleDetailPage() {
	const { articleId } = useParams();
	const [article, setArticle] = useState<IArticleDetail>();

	const fetchData = async () => {
		try {
			if (articleId) {
				const response = await getArticleApi(articleId);
				console.log(response);
				if (response.status === 200) {
					setArticle(response.data.data);
				}
			}
		} catch (error) {
			console.error(error);
		}
	};

	useEffect(() => {
		fetchData();
	}, []);
	return (
		<PageLayout>
			<ArticleDetailPageLayout
				ArticleHeader={
					<ArticleHeader
						title={article?.title ?? 'title'}
						writer={article?.writer ?? 'writer'}
						publishedDate={article?.publishedDate ?? null}
						count={article?.count ?? 0}
					/>
				}
				ArticleKeywordList={<ArticleKeywordList keywords={DUMMY_KEYWORDS} />}
				ArticleContent={<ArticleContent content={article?.content ?? 'content'} />}
				RecommendedArticleList={<DetailRecommendedArticleList />}
				Footer={<Footer />}
			/>
		</PageLayout>
	);
}

export default ArticleDetailPage;
