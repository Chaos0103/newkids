import React from 'react';
import { IKeyword } from 'types/keyword';
import KeywordListItem from 'components/atoms/common/KeywordListItem';
import { ArticleKeywordListContainer } from './style';

interface IArticleKeywordListProps {
	keywords: IKeyword[];
}

function ArticleKeywordList(props: IArticleKeywordListProps) {
	const { keywords } = props;
	return (
		<ArticleKeywordListContainer>
			<h3 className="header">주요 키워드</h3>
			<div className="keywords">
				{keywords.length ? keywords.map((el) => <KeywordListItem text={el.word} key={el.keywordId} />) : <div />}
			</div>
		</ArticleKeywordListContainer>
	);
}

export default ArticleKeywordList;
