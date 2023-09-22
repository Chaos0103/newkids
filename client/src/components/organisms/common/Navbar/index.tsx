import React, { useState } from 'react';
import { ReactComponent as DownIcon } from 'assets/icons/down.svg';
import { ReactComponent as Logo } from 'assets/imgs/newkids-logo.svg';
import SearchBar from 'components/atoms/common/SearchBar';
import Button from 'components/atoms/common/Button';
import useMovePage from 'hooks/useMovePage';
import { useRecoilState } from 'recoil';
import { MemberInfoState } from 'store/auth';
import { NavBarContainer } from './style';

export function AuthNavBar() {
	const [movePage] = useMovePage();

	return (
		<NavBarContainer $auth>
			<div className="logo auth-navbar">
				<Logo onClick={() => movePage('/')} />
			</div>
		</NavBarContainer>
	);
}

function NavBar() {
	const [memberInfoState] = useRecoilState(MemberInfoState);
	const [movePage] = useMovePage();
	const [searchValue, setSearchValue] = useState('');

	return (
		<NavBarContainer>
			<div className="logo">
				<Logo onClick={() => movePage('/')} />
			</div>
			<div className="search-bar">
				<SearchBar
					size="l"
					confirmSearch={() => {}}
					value={searchValue}
					setValue={setSearchValue}
					color="SubFirst"
					placeholder="검색어를 입력하세요"
				/>
			</div>
			{/* 로그인 여부에 따라 다르게 표시 */}
			{memberInfoState ? (
				<button className="member-info" type="button">
					<span>{memberInfoState.nickname}님</span> <DownIcon />
				</button>
			) : (
				<Button size="s" radius="l" color="Primary" text="로그인" handleClick={() => movePage('/auth/login')} />
			)}
		</NavBarContainer>
	);
}

export default NavBar;
