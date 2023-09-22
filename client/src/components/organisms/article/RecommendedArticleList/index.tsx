import React, { useState, useEffect } from 'react';
import { IArticle } from 'types/article';
import { DUMMY_ARTICLES_6 } from 'constants/dummy';
import RectangleArticleListItem from 'components/atoms/article/RectangleArticleListItem';
import { RecommendedArticleListContainer } from './style';

function RecommendedArticleList() {
	const [articles, setArticles] = useState<IArticle[]>([]);

	// TODO : 추천 API 나오면 교체
	useEffect(() => {
		setArticles(DUMMY_ARTICLES_6);
	}, []);

	return (
		<RecommendedArticleListContainer>
			{articles.length ? articles.map((el) => <RectangleArticleListItem article={el} />) : <div />}
		</RecommendedArticleListContainer>
	);
}

export default RecommendedArticleList;
