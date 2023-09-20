import styled from 'styled-components';

export const ModalComponentContainer = styled.div<{ isOpen: boolean }>`
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	display: ${({ isOpen }) => (isOpen ? 'block' : 'none')};
`;
