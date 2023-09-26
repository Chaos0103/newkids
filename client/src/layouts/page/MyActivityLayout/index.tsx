import React, { ReactNode } from 'react';
import { ContentLayout, FullContentLayout } from 'layouts/common/ContentLayout';
import { MyActivityLayoutContainer } from './style';

interface IMyActivityLayoutProps {
	MyActivityChart: ReactNode;
	MyActivityArticle: ReactNode;
	MyPageMenu: ReactNode;
	UserProfile: ReactNode;
}

function MyActivityLayout({ MyPageMenu, MyActivityChart, MyActivityArticle, UserProfile }: IMyActivityLayoutProps) {
	return (
		<MyActivityLayoutContainer>
			<div className="user-profile">
				<FullContentLayout>{UserProfile}</FullContentLayout>
			</div>
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
