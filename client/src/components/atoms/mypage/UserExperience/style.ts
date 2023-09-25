import styled from 'styled-components';

export const USerExperienceWrapper = styled.div<{ isBar: number }>`
	.user-experience-wrapper {
		width: 100%;
		.user-experience-content {
			justify-content: center;
		}
	}
	.user-experience-content {
		width: 100%;
		font-size: 24px;
		color: var(--gray-500);
		display: flex;
		align-item: center;
	}

	.user-experience-bar {
		margin-top: 1rem;
		width: 250px;
		height: 30px;
		background-color: var(--white-color);
		border: 1px solid var(--gray-300);
		position: relative;
	}

	.experience-fill {
		height: 100%;
		width: ${(props) => props.isBar || 0}%;
		background-color: var(--main-color);
	}
`;
