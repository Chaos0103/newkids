import React from 'react';
import { IArticle } from 'types/article';
import SearchResultArticleListItem from 'components/atoms/article/SearchResultArticleListItem';
import { SearchResultArticleListContainer } from './style';

interface ISearchResultArticleListProps {
	articles: IArticle[];
	totalElements: number;
}

function SearchResultArticleList(props: ISearchResultArticleListProps) {
	const { articles, totalElements } = props;

	return (
		<SearchResultArticleListContainer>
			<h3>총 {totalElements}건의 기사 검색결과가 있습니다.</h3>
			{articles.length ? (
				articles.map((el) => <SearchResultArticleListItem key={el.articleId} article={el} />)
			) : (
				<div>기간 내 검색된 기사가 없습니다.</div>
			)}
		</SearchResultArticleListContainer>
	);
}

export default SearchResultArticleList;
