import { describe, it, expect } from 'vitest'
import { getFullName } from '../../functions/1-types'

describe('getFullName', () => {
  it('retourne une chaîne de caractères', () => {
    expect(typeof getFullName('first', 'last')).toBe('string')
  })

  it('retourne le nom correctement formaté', () => {
    expect(getFullName('first', 'last')).toBe('first last')
    expect(getFullName('Bruce', 'Wayne')).toBe('Bruce Wayne')
  })
})
