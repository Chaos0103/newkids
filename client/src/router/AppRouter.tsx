import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import { GlobalFonts } from 'styles/GlobalFonts';
import { GlobalStyles } from 'styles/GlobalStyles';
import ApplicationLayout from 'layouts/common/ApplicationLayout';
import IndexPage from '../pages/IndexPage';
import Navigation from '../components/organisms/common/Navigation';

function AppRouter() {
	return (
		<RecoilRoot>
			<GlobalFonts />
			<GlobalStyles />
			<BrowserRouter>
				<ApplicationLayout>
					<Navigation />
					<Routes>
						<Route path="/" element={<IndexPage />} />
					</Routes>
				</ApplicationLayout>
			</BrowserRouter>
		</RecoilRoot>
	);
}

export default AppRouter;
