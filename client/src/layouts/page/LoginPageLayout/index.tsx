import React, { ReactNode } from 'react';
import { LarrowContentLayout } from 'layouts/common/ContentLayout';
import { LoginPageLayoutContainer } from './style';

interface ILoginPageLayoutProps {
	Title: ReactNode;
	LoginForm: ReactNode;
	Footer: ReactNode;
}
function LoginPageLayout({ Title, LoginForm, Footer }: ILoginPageLayoutProps) {
	return (
		<LoginPageLayoutContainer>
			<div className="title">
				<LarrowContentLayout>{Title}</LarrowContentLayout>
			</div>
			<div className="login-form">
				<LarrowContentLayout>{LoginForm}</LarrowContentLayout>
			</div>
			<div className="footer">
				<LarrowContentLayout>{Footer}</LarrowContentLayout>
			</div>
		</LoginPageLayoutContainer>
	);
}

export default LoginPageLayout;
