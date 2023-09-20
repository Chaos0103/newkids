import React, { ReactNode } from 'react';
import { ContentLayout } from 'layouts/common/ContentLayout';
import { MyActivityLayoutContainer } from './style';

interface IMyActivityLayoutProps {
	MyActivityChart: ReactNode;
	MyActivityArticle: ReactNode;
	MyPageMenu: ReactNode;
}

function MyActivityLayout({ MyPageMenu, MyActivityChart, MyActivityArticle }: IMyActivityLayoutProps) {
	return (
		<MyActivityLayoutContainer>
			<div className="my-page-menu">
				<ContentLayout>{MyPageMenu}</ContentLayout>
			</div>
			<div className="my-activity-chart">
				<ContentLayout>{MyActivityChart}</ContentLayout>
			</div>
			<div className="my-activity-article">
				<ContentLayout>{MyActivityArticle}</ContentLayout>
			</div>
		</MyActivityLayoutContainer>
	);
}

export default MyActivityLayout;
