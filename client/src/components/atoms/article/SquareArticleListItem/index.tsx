import React from 'react';
import { IArticle } from 'types/article';
import { useNavigate } from 'react-router-dom';
import { SquareArticleListItemContainer } from './style';

interface ISquareArticleListItemProps {
	article: IArticle;
}
function SquareArticleListItem(props: ISquareArticleListItemProps) {
	const navigate = useNavigate();
	const { article } = props;

	return (
		<SquareArticleListItemContainer onClick={() => navigate(`/article/${article.articleId}`)}>
			<img src={article.thumbnailImg} alt="" />
			<h2>{article.title}</h2>
			<div className="overlay" />
		</SquareArticleListItemContainer>
	);
}

export default SquareArticleListItem;
