import React, { useState, useEffect } from 'react';
import SquareArticleListItem from 'components/atoms/article/SquareArticleListItem';
import { IArticle } from 'types/article';
import { DUMMY_ARTICLES_5 } from 'constants/dummy';
import { PopularArticleListContainer } from './style';

function PopularArticleList() {
	const [articles, setArticles] = useState<IArticle[]>([]);

	// TODO : 추천 API 나오면 교체
	useEffect(() => {
		setArticles(DUMMY_ARTICLES_5);
	}, []);

	return (
		<PopularArticleListContainer>
			{articles.length ? articles.map((ar) => <SquareArticleListItem key={ar.articleId} article={ar} />) : <div />}{' '}
		</PopularArticleListContainer>
	);
}

export default PopularArticleList;
