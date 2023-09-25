import React from 'react';
import { USerExperienceWrapper } from './style';

interface IUSerExperienceProps {
	experienceValue: number;
}
function USerExperience({ experienceValue }: IUSerExperienceProps) {
	return (
		<USerExperienceWrapper isBar={experienceValue}>
			<div className="user-experience-wrapper">
				<div className="user-experience-content">Exp {experienceValue} / 100</div>
				<div className="user-experience-bar">
					<div className="experience-fill" />
				</div>
			</div>
		</USerExperienceWrapper>
	);
}

export default USerExperience;
