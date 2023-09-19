import React from 'react';
import { MypageMenus } from 'constants/mypage';
import MypageMenuItem from 'components/atoms/common/MypageMenuItem';
import { MyPageMenuContainer } from './style';

function MyPageMenu() {
	return (
		<MyPageMenuContainer>
			<div className="mypage-container">
				{MypageMenus.map((e) => (
					<MypageMenuItem key={e.key} menu={e} />
				))}
			</div>
		</MyPageMenuContainer>
	);
}

export default MyPageMenu;
