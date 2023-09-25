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
import JoinPage from 'pages/auth/JoinPage';
import MyActivity from 'pages/MyActivity';
import ArticleDetailPage from 'pages/article/ArticleDetailPage';
import ArticleFindPage from 'pages/article/ArticleFindPage';
import PrivateRoute from './PrivateRoute';
import AuthProvider from './AuthProvider';
import MyCollection from 'pages/MyCollection';

function AppRouter() {
	return (
		<RecoilRoot>
			<GlobalFonts />
			<GlobalStyles />
			<GlobalKeyFrames />
			<ApplicationLayout>
				<AuthProvider>
					<BrowserRouter>
						<Navigation />
						<Routes>
							<Route path="/" element={<IndexPage />} />
							<Route path="/article" element={<ArticleFindPage />} />
							<Route path="/article/:articleId" element={<ArticleDetailPage />} />
							<Route path="/auth/login" element={<LoginPage />} />
							<Route path="/auth/join" element={<JoinPage />} />
							<Route path="/mypage/info" element={<MyPage />} />
							<Route path="/mypage/activity" element={<MyActivity />} />
							<Route path="/mypage/collection" element={<MyCollection />} />

							<Route path="/" element={<PrivateRoute />}>
								<Route path="/game" element={<div />} />
								<Route path="/quiz" element={<div />} />
							</Route>
						</Routes>
					</BrowserRouter>
				</AuthProvider>
			</ApplicationLayout>
		</RecoilRoot>
	);
}

export default AppRouter;
