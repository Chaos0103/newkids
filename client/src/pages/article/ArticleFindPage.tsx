import React, { useState } from 'react';
import Footer from 'components/organisms/common/Footer';
import PageLayout from 'layouts/common/PageLayout';
import ArticleFindPageLayout from 'layouts/page/ArticleFindPageLayout';
import SearchOptions from 'components/organisms/article/SearchOptions';
import { IArticle } from 'types/article';
import SearchResultArticleList from 'components/organisms/article/SearchResultArticleList';

function ArticleFindPage() {
	const [resultArticles, setResultArticles] = useState<IArticle[]>([]);

	return (
		<PageLayout>
			<ArticleFindPageLayout
				SearchOptions={
					<>
						<h3>기간별 조회</h3>
						<SearchOptions setResultArticles={setResultArticles} />
					</>
				}
				ResultArticleList={<SearchResultArticleList articles={resultArticles} />}
				Pagination={<div />}
				Footer={<Footer />}
			/>
		</PageLayout>
	);
}

export default ArticleFindPage;
