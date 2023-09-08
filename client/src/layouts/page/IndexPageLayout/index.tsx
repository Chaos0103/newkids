import React, { ReactNode } from 'react';
import { FullContentLayout } from 'layouts/common/ContentLayout';
import { IndexPageLayoutContainer } from './style';

interface IIndexPageLayoutProps {
	RecommandArticles: ReactNode;
}

function IndexPageLayout({ RecommandArticles }: IIndexPageLayoutProps) {
	return (
		<IndexPageLayoutContainer>
			<FullContentLayout>{RecommandArticles}</FullContentLayout>
		</IndexPageLayoutContainer>
	);
}

export default IndexPageLayout;
