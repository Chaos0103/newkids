import React, { useEffect, useState } from 'react';
import ArticleContent from 'components/organisms/article/ArticleContent';
import ArticleHeader from 'components/organisms/article/ArticleHeader';
import ArticleKeywordList from 'components/organisms/article/ArticleKeywordList';
import DetailRecommendedArticleList from 'components/organisms/article/DetailRecommendedArticleList';
import Footer from 'components/organisms/common/Footer';
import PageLayout from 'layouts/common/PageLayout';
import ArticleDetailPageLayout from 'layouts/page/ArticleDetailPageLayout';
import { useParams } from 'react-router-dom';
import { IArticleDetail } from 'types/article';
import { getArticleApi } from 'utils/apis/article';
import { getArticleKeywordApi } from 'utils/apis/keyword';
import { IKeyword } from 'types/keyword';

function ArticleDetailPage() {
	const { articleId } = useParams();
	const [article, setArticle] = useState<IArticleDetail>();
	const [articleKeywords, setArticleKeywords] = useState<IKeyword[]>([]);

	const fetchKeywordData = async () => {
		try {
			if (articleId) {
				const response = await getArticleKeywordApi(articleId);
				console.log(response);
				if (response.status === 200) {
					setArticleKeywords(response.data.data);
				}
			}
		} catch (error) {
			console.error(error);
		}
	};
	const fetchArticleData = async () => {
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
		fetchKeywordData();
		fetchArticleData();
	}, []);

	return (
		<PageLayout>
			<ArticleDetailPageLayout
				ArticleHeader={
					<ArticleHeader
						title={article?.title ?? 'title'}
						writer={article?.writer ?? 'writer'}
						publishedDate={article?.publishedDate ?? ''}
						count={article?.count ?? 0}
					/>
				}
				ArticleKeywordList={<ArticleKeywordList keywords={articleKeywords} />}
				ArticleContent={<ArticleContent content={article?.content ?? 'content'} />}
				RecommendedArticleList={<DetailRecommendedArticleList />}
				Footer={<Footer />}
			/>
		</PageLayout>
	);
}

export default ArticleDetailPage;
