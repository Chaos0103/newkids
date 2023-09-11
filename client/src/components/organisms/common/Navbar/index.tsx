import React from 'react';
import { ReactComponent as Logo } from 'assets/imgs/newkids-logo.svg';
import SearchBar from 'components/atoms/common/SearchBar';
import Button from 'components/atoms/common/Button';
import { useNavigate } from 'react-router-dom';
import { NavBarContainer } from './style';

export function AuthNavBar() {
	return (
		<NavBarContainer $auth>
			<div className="logo auth-navbar">
				<Logo />
			</div>
		</NavBarContainer>
	);
}

function NavBar() {
	const navigate = useNavigate();

	const moveLogin = () => {
		navigate('/auth/login');
	};

	return (
		<NavBarContainer>
			<div className="logo">
				<Logo />
			</div>
			<div className="search-bar">
				<SearchBar />
			</div>
			<Button size="l" radius="s" color="SubSecond" text="로그인" handleClick={moveLogin} />
		</NavBarContainer>
	);
}

export default NavBar;
