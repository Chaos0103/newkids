import React, { ReactNode } from 'react';
import { ContentLayout, FullContentLayout } from 'layouts/common/ContentLayout';
import { ArticleFindPageLayoutContainer } from './style';

interface IArticleFindPageLayoutProps {
	TrendingKeywordList: ReactNode;
	SearchOptions: ReactNode;
	ResultArticleList: ReactNode;
	Footer: ReactNode;
}

function ArticleFindPageLayout(props: IArticleFindPageLayoutProps) {
	const { TrendingKeywordList, SearchOptions, ResultArticleList, Footer } = props;
	return (
		<ArticleFindPageLayoutContainer>
			<ContentLayout>
				<div className="recommended-article-list">{TrendingKeywordList}</div>
				<div className="search-options">{SearchOptions}</div>
				<div className="result-article-list">{ResultArticleList}</div>
			</ContentLayout>
			<FullContentLayout>
				<div className="footer">{Footer}</div>
			</FullContentLayout>
		</ArticleFindPageLayoutContainer>
	);
}

export default ArticleFindPageLayout;
