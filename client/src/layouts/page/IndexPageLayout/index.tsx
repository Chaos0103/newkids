import React, { ReactNode } from 'react';
import { ContentLayout } from 'layouts/common/ContentLayout';
import { IndexPageLayoutContainer } from './style';

interface IIndexPageLayoutProps {
	RecommandArticles: ReactNode;
}

function IndexPageLayout({ RecommandArticles }: IIndexPageLayoutProps) {
	return (
		<IndexPageLayoutContainer>
			<ContentLayout>{RecommandArticles}</ContentLayout>
		</IndexPageLayoutContainer>
	);
}

export default IndexPageLayout;
