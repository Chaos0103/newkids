import React from 'react';
import { IArticle } from 'types/article';
import SearchResultArticleListItem from 'components/atoms/article/SearchResultArticleListItem';
import { SearchResultArticleListContainer } from './style';

interface ISearchResultArticleListProps {
	articles: IArticle[];
}

function SearchResultArticleList(props: ISearchResultArticleListProps) {
	const { articles } = props;

	return (
		<SearchResultArticleListContainer>
			{articles ? articles.map((el) => <SearchResultArticleListItem key={el.articleId} article={el} />) : <div />}
		</SearchResultArticleListContainer>
	);
}

export default SearchResultArticleList;
