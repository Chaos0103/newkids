import React, { ReactNode } from 'react';
import { ContentLayout, FullContentLayout } from 'layouts/common/ContentLayout';
import { MyCollectionLayoutContainer } from './style';

interface IMyCollectionLayoutProps {
	MyPageMenu: ReactNode;
	UserProfile: ReactNode;
	MyCollectionArticle: ReactNode;
}

function MyCollectionLayout({ UserProfile, MyPageMenu, MyCollectionArticle }: IMyCollectionLayoutProps) {
	return (
		<MyCollectionLayoutContainer>
			<div className="user-profile">
				<FullContentLayout>{UserProfile}</FullContentLayout>
			</div>
			<div className="my-page-menu">
				<ContentLayout>{MyPageMenu}</ContentLayout>
			</div>
			<div className="my-collection-article">
				<ContentLayout>{MyCollectionArticle}</ContentLayout>
			</div>
		</MyCollectionLayoutContainer>
	);
}

export default MyCollectionLayout;
