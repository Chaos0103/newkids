import React, { useState, useEffect } from 'react';
import NavBar, { AuthNavBar } from 'components/organisms/common/Navbar';
import Menubar from 'components/organisms/common/Menubar';
import NavigationLayout, { AuthNavigationLayout } from 'layouts/common/NavigationLayout';
import { useLocation } from 'react-router-dom';
import { useRecoilState } from 'recoil';
import { AuthState } from 'store/auth';
import { getMemberInfoApi } from 'utils/apis/auth';

function Navigation() {
	const [authState] = useRecoilState(AuthState);
	const [isAuthPage, setIsAuthPage] = useState(false);
	const location = useLocation();

	const fetchMember = async () => {
		try {
			if (authState) {
				const response = await getMemberInfoApi(authState?.memberkey);
				console.log(response);
			}
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		fetchMember();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [authState]);

	useEffect(() => {
		if (/\/auth/.test(location.pathname)) {
			setIsAuthPage(true);
		} else {
			setIsAuthPage(false);
		}
	}, [location]);

	if (isAuthPage) return <AuthNavigationLayout Navibar={<AuthNavBar />} />;
	return <NavigationLayout Navibar={<NavBar />} Menubar={<Menubar />} />;
}

export default Navigation;
