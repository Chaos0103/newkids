import styled from 'styled-components';

export const LoginFooterContainer = styled.div`
	position: fixed;
	bottom: 3rem;
	width: 100%;
	left: 50%;
	right: 50%;
	transform: translateX(-50%);
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	gap: 0.5rem;

	.team {
		margin-bottom: 1rem;
	}
	.copyright {
		font-weight: bold;
		display: flex;
		align-items: center;
		gap: 2rem;

		img {
			width: 8rem;
		}
	}
`;
