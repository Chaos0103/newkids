import styled from 'styled-components';

export const UserFiguresContainer = styled.div`
	background-color: var(--sub-color-1);
	width: 100%;

	.user-figure-container {
		margin-top: 3rem;
	}

	.figure-image {
		height: 250px;
		display: flex;
		justify-content: center;
		align-items: center;
		background-color: var(--main-color);
	}

	.figure-image-content {
		background-color: var(--danger-color);
	}

	.user-experience-container {
		background-color: var(--success-color);
		display: flex;
		justify-content: center;
		margin-top: 1.5rem;
	}
`;
