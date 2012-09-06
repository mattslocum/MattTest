/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AExpAType extends PAType
{
    private TLBar _lBar_;
    private PAType _aType_;
    private PAExpr _aExpr_;

    public AExpAType()
    {
        // Constructor
    }

    public AExpAType(
        @SuppressWarnings("hiding") TLBar _lBar_,
        @SuppressWarnings("hiding") PAType _aType_,
        @SuppressWarnings("hiding") PAExpr _aExpr_)
    {
        // Constructor
        setLBar(_lBar_);

        setAType(_aType_);

        setAExpr(_aExpr_);

    }

    @Override
    public Object clone()
    {
        return new AExpAType(
            cloneNode(this._lBar_),
            cloneNode(this._aType_),
            cloneNode(this._aExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpAType(this);
    }

    public TLBar getLBar()
    {
        return this._lBar_;
    }

    public void setLBar(TLBar node)
    {
        if(this._lBar_ != null)
        {
            this._lBar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBar_ = node;
    }

    public PAType getAType()
    {
        return this._aType_;
    }

    public void setAType(PAType node)
    {
        if(this._aType_ != null)
        {
            this._aType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aType_ = node;
    }

    public PAExpr getAExpr()
    {
        return this._aExpr_;
    }

    public void setAExpr(PAExpr node)
    {
        if(this._aExpr_ != null)
        {
            this._aExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBar_)
            + toString(this._aType_)
            + toString(this._aExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBar_ == child)
        {
            this._lBar_ = null;
            return;
        }

        if(this._aType_ == child)
        {
            this._aType_ = null;
            return;
        }

        if(this._aExpr_ == child)
        {
            this._aExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBar_ == oldChild)
        {
            setLBar((TLBar) newChild);
            return;
        }

        if(this._aType_ == oldChild)
        {
            setAType((PAType) newChild);
            return;
        }

        if(this._aExpr_ == oldChild)
        {
            setAExpr((PAExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}