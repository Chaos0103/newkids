import React, { useState, useEffect } from 'react';
import SquareArticleListItem from 'components/atoms/article/SquareArticleListItem';
import { IArticle } from 'types/article';
import { DUMMY_ARTICLES_5 } from 'constants/dummy';
import { getAllRecommendedArticleApi } from 'utils/apis/article';
import { PopularArticleListContainer } from './style';

function PopularArticleList() {
	const [articles, setArticles] = useState<IArticle[]>([]);

	// TODO : API 데이터로 set하기
	const fetchData = async () => {
		try {
			const response = await getAllRecommendedArticleApi();
			console.log(response);

			if (response.status === 200) {
				setArticles(DUMMY_ARTICLES_5);
			}
		} catch (error) {
			console.error(error);
		}
	};

	useEffect(() => {
		fetchData();
	}, []);

	return (
		<PopularArticleListContainer>
			{articles.length ? articles.map((ar) => <SquareArticleListItem key={ar.articleId} article={ar} />) : <div />}{' '}
		</PopularArticleListContainer>
	);
}

export default PopularArticleList;
