import React from 'react';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import { GlobalFonts } from 'styles/GlobalFonts';
import { GlobalStyles } from 'styles/GlobalStyles';
import ApplicationLayout from 'layouts/common/ApplicationLayout';
import { GlobalKeyFrames } from 'styles/GlobalKeyFrames';
import Navigation from 'components/organisms/common/Navigation';
import IndexPage from 'pages/IndexPage';
import QuizPage from 'pages/QuizPage';
import GamePage from 'pages/GamePage';
import MyPage from 'pages/MyPage';
import LoginPage from 'pages/auth/LoginPage';
import MyActivity from 'pages/MyActivity';
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
						<Route path="/" element={<Navigate to="/index" />} />
						<Route path="/index" element={<IndexPage />} />
						<Route path="/account/login" element={<div />} />
						<Route path="/index/auth/login" element={<LoginPage />} />
						<Route path="/" element={<IndexPage />} />
						<Route path="/auth/login" element={<LoginPage />} />
						<Route path="/mypage/info" element={<MyPage />} />
						<Route path="/mypage/activity" element={<MyActivity />} />

						<Route path="/" element={<PrivateRoute />}>
							<Route path="/game" element={<GamePage />} />
							<Route path="/quiz" element={<QuizPage />} />
						</Route>
					</Routes>
				</BrowserRouter>
			</ApplicationLayout>
		</RecoilRoot>
	);
}

export default AppRouter;
