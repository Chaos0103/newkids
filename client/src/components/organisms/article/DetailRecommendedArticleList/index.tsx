import React, { useState, useEffect } from 'react';
import { IArticle } from 'types/article';
import { DUMMY_ARTICLES_6 } from 'constants/dummy';
import { getAllArticleApi } from 'utils/apis/article';
import SquareArticleListItem from 'components/atoms/article/SquareArticleListItem';
import { DetailRecommendedArticleListContainer } from './style';

function DetailRecommendedArticleList() {
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
		<DetailRecommendedArticleListContainer>
			<h3 className="recommended-article-header">이런 기사는 어떠세요?</h3>
			<div className="list-items">
				{articles.length ? articles.map((el) => <SquareArticleListItem article={el} key={el.articleId} />) : <div />}
			</div>
		</DetailRecommendedArticleListContainer>
	);
}

export default DetailRecommendedArticleList;
