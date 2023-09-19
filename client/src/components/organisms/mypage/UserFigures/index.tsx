import React from 'react';
import USerExperience from 'components/atoms/mypage/UserExperience';
import UserLevel from 'components/atoms/mypage/UserLevel';
import { UserFiguresContainer } from './style';

function UserFigures() {
	return (
		<UserFiguresContainer>
			<div className="user-figure-container">
				<div className="figure-image">
					<div className="figure-image-content">프로필 이미지</div>
				</div>
				<div className="user-experience-container">
					<USerExperience />
				</div>
				<div className="user-level-container">
					<UserLevel />
				</div>
			</div>
		</UserFiguresContainer>
	);
}

export default UserFigures;
