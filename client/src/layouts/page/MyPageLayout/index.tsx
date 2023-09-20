import React, { ReactNode } from 'react';
import { ContentLayout, FullContentLayout } from 'layouts/common/ContentLayout';
import { MyPageLayoutContainer } from './style';

interface IMyPageLayoutProps {
	UserProfile: ReactNode;
	MyPageMenu: ReactNode;
	UserDetail: ReactNode;
	UserFigures: ReactNode;
}

function MyPageLayout({ UserProfile, MyPageMenu, UserDetail, UserFigures }: IMyPageLayoutProps) {
	return (
		<MyPageLayoutContainer>
			<div className="user-profile">
				<FullContentLayout>{UserProfile}</FullContentLayout>
			</div>

			<div className="my-page-menu">
				<ContentLayout>{MyPageMenu}</ContentLayout>
			</div>
			{/* <hr /> */}
			<ContentLayout>
				<div className="user-info">
					{UserFigures}
					{UserDetail}
				</div>
			</ContentLayout>
		</MyPageLayoutContainer>
	);
}

export default MyPageLayout;
