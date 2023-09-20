import React from 'react';
import { USerExperienceWrapper } from './style';

function USerExperience() {
	return (
		<USerExperienceWrapper>
			<div className="user-experience-wrapper">
				<div className="user-experience-content">Exp 45 / 100</div>
				<div className="experience-image-container">
					<div className="user-experience-image">경험치 Bar 이미지</div>
				</div>
			</div>
		</USerExperienceWrapper>
	);
}

export default USerExperience;
