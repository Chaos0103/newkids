import Footer from 'components/organisms/common/Footer';
import PageLayout from 'layouts/common/PageLayout';
import ArticleFindPageLayout from 'layouts/page/ArticleFindPageLayout';
import React from 'react';

function ArticleFindPage() {
	return (
		<PageLayout>
			<ArticleFindPageLayout
				TrendingKeywordList={<div />}
				SearchOptions={<div />}
				ResultArticleList={<div />}
				Footer={<Footer />}
			/>
		</PageLayout>
	);
}

export default ArticleFindPage;
