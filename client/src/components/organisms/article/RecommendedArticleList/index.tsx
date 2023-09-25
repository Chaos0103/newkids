import React, { useState, useEffect } from 'react';
import { IArticle } from 'types/article';
import { DUMMY_ARTICLES_6 } from 'constants/dummy';
import RectangleArticleListItem from 'components/atoms/article/RectangleArticleListItem';
import { getAllArticleApi } from 'utils/apis/article';
import { RecommendedArticleListContainer } from './style';

function RecommendedArticleList() {
	const [articles, setArticles] = useState<IArticle[]>([]);

	const fetchData = async () => {
		try {
			const response = await getAllArticleApi('2023-01-01', '2023-09-01');
			console.log('::getAllArticleApi', response);
		} catch (error) {
			console.error(error);
		}
	};
	// TODO : 추천 API 나오면 교체
	useEffect(() => {
		setArticles(DUMMY_ARTICLES_6);
		fetchData();
	}, []);

	return (
		<RecommendedArticleListContainer>
			{articles.length ? articles.map((el) => <RectangleArticleListItem article={el} key={el.articleId} />) : <div />}
		</RecommendedArticleListContainer>
	);
}

export default RecommendedArticleList;
