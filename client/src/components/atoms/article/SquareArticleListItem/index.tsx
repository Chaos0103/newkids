import React from 'react';
import { IArticle } from 'types/article';
import { SquareArticleListItemContainer } from './style';

interface ISquareArticleListItemProps {
	article: IArticle;
}
function SquareArticleListItem(props: ISquareArticleListItemProps) {
	const { article } = props;

	return (
		<SquareArticleListItemContainer>
			<img src={article.thumbnailImg} alt="" />
			<h2>{article.title}</h2>
			<div className="overlay" />
		</SquareArticleListItemContainer>
	);
}

export default SquareArticleListItem;
