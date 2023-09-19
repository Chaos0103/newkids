import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import { GlobalFonts } from 'styles/GlobalFonts';
import { GlobalStyles } from 'styles/GlobalStyles';
import ApplicationLayout from 'layouts/common/ApplicationLayout';
import { GlobalKeyFrames } from 'styles/GlobalKeyFrames';
import Navigation from 'components/organisms/common/Navigation';
import IndexPage from 'pages/IndexPage';
import MyPage from 'pages/MyPage';
import LoginPage from 'pages/auth/LoginPage';
import PrivateRoute from './PrivateRoute';

function AppRouter() {
	return (
		<RecoilRoot>
			<GlobalFonts />
			<GlobalStyles />
			<GlobalKeyFrames />
			<ApplicationLayout>
				<BrowserRouter>
					<Navigation />
					<Routes>
						<Route path="/" element={<IndexPage />} />
						<Route path="/auth/login" element={<LoginPage />} />
						<Route path="/mypage/info" element={<MyPage />} />

						<Route path="/" element={<PrivateRoute />}>
							<Route path="/game" element={<div />} />
							<Route path="/quiz" element={<div />} />
						</Route>
					</Routes>
				</BrowserRouter>
			</ApplicationLayout>
		</RecoilRoot>
	);
}

export default AppRouter;
